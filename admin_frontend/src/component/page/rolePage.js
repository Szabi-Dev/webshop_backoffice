import React, { useEffect, useState } from 'react'
import SearchBar from '../dataTable/common/searchBar' 
import AddModal from '../dataTable/modal/addModal'
import BasicTable from '../dataTable/common/table'
import Button from '@material-ui/core/Button';
import {RestCaller} from '../../services/util/restCaller';


import { RoleAddGeneralTab } from '../dataTable/form/roleAddForm';
import { RoleEditGeneralTab } from '../dataTable/form/roleEditForm';
import {ROLE_URI} from '../../services/util/constants'



const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'name', headerName: 'Name'},
  ];
  
const filterBy= ["name", "id"]

export default function RolePage(){
    const [rowList, setRowList] = React.useState([]);
    const [defaultRowList, setDefaultRowList] = React.useState([]);
    const [isOpen, setIsOpen] = React.useState(false);
    const [addLink, setAddLink] = React.useState("")
    const [newRole, setNewRole] = React.useState({})
    
    const handleAddChange = (event) =>{
        newRole[event.target.name] = event.target.value
        setNewRole(newRole)
    }

    const addModaltabs = [
      {id: 'general', displayName: "General", index: 0, content:  <RoleAddGeneralTab handleAddChange={handleAddChange} /> }
    ]

    const editModaltabs = [
        {id: 'general', displayName: "General", index: 0, content:  <RoleEditGeneralTab /> }
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
        await RestCaller().makeRequest(ROLE_URI).then((data) =>{
            let dataList
            if ('_embedded' in data) {
                dataList = data['_embedded']['roleDataList']
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
        <h1> Role</h1>
        <SearchBar defaultRowList={defaultRowList} getFilteredRows={setFilteredRows} filterBy={filterBy}/>
        <Button variant="contained" onClick={openModal}> Add</Button>  
        <AddModal show={isOpen} tabs={addModaltabs} actionLink={addLink} payLoad={newRole} handleModalClose={closeModal}/>
        <BasicTable columns={columns} rows={rowList} handleResponse={fetchData} editTabs={editModaltabs} />
     </div> 
    );

}