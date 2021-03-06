import React, { useEffect, useState } from 'react'
import SearchBar from '../dataTable/common/searchBar' 
import AddModal from '../dataTable/modal/addModal'
import BasicTable from '../dataTable/common/table'
import Button from '@material-ui/core/Button';
import {RestCaller} from '../../services/util/restCaller';


import {PRIVILEGE_URI} from '../../services/util/constants'
import { PrivilegeAddGeneralTab } from '../dataTable/form/privilegeAddFrom';
import { PrivilegeEditGeneralTab } from '../dataTable/form/privilegeEditForm';



const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'name', headerName: 'Name'},
  ];
  
const filterBy= ["name", "id"]

export default function PrivilegePage(){
    const [rowList, setRowList] = React.useState([]);
    const [defaultRowList, setDefaultRowList] = React.useState([]);
    const [isOpen, setIsOpen] = React.useState(false);
    const [addLink, setAddLink] = React.useState("")
    const [newPrivilege, setNewPrivilege] = React.useState({})
    
    const handleAddChange = (event) =>{
        newPrivilege[event.target.name] = event.target.value
        setNewPrivilege(newPrivilege)
    }

    const addModaltabs = [
      {id: 'general', displayName: "General", index: 0, content:  <PrivilegeAddGeneralTab handleAddChange={handleAddChange} /> }
    ]

    const editModaltabs = [
        {id: 'general', displayName: "General", index: 0, content:  <PrivilegeEditGeneralTab /> }
      ]

    const openModal = () => {
        setIsOpen(true)
    }

    const closeModal = () => {
        setIsOpen(false)
        fetchData()
    }

    const setFilteredRows = (filteredList) => {
        setRowList(filteredList)
    }
    
    async function fetchData() {
        // You can await here
        await RestCaller().makeRequest(PRIVILEGE_URI).then((data) =>{
            let dataList
            if ('_embedded' in data) {
                dataList = data['_embedded']['privilegeDataList']
            } else {
                dataList = []
            }
            
            setDefaultRowList(dataList)
            setRowList(dataList)
            setAddLink(data["_links"]["create"])
        });
      }

    useEffect (() => { fetchData() }, [])

    return (
    <div>
        <h1> Privilege</h1>
        <SearchBar defaultRowList={defaultRowList} getFilteredRows={setFilteredRows} filterBy={filterBy}/>
        <Button variant="contained" onClick={openModal}> Add</Button>  
        <AddModal show={isOpen} tabs={addModaltabs} actionLink={addLink} payLoad={newPrivilege} handleModalClose={closeModal}/>
        <BasicTable columns={columns} rows={rowList} handleResponse={fetchData} editTabs={editModaltabs} />
     </div> 
    );

}