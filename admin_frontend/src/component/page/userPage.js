import React, { useEffect, useState } from 'react';
import {RestCaller} from '../../services/util/restCaller';
import {USER_URI} from '../../services/util/constants'
import {UserAddGeneralTab} from '../dataTable/form/userAddForm'
import SearchBar from '../dataTable/common/searchBar' 
import AddModal from '../dataTable/modal/addModal'
import BasicTable from '../dataTable/common/table'
import Button from '@material-ui/core/Button';

const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'firstName', headerName: 'First name'},
    { field: 'lastName', headerName: 'Last name' },
    { field: 'email', headerName: 'Email' }
  ];
  

const filterBy= ["lastName", "firstName", "id", "age"]



export default function UserPage(props){
    const [rowList, setRowList] = React.useState([]);
    const [defaultRowList, setDefaultRowList] = React.useState([]);
    const [isOpen, setIsOpen] = React.useState(false);
    const [addLink, setAddLink] = React.useState("")
    const [newUser, setNewUser] = React.useState({})
    
    const handleAddChange = (event) =>{
        newUser[event.target.name] = event.target.value
        setNewUser(newUser)
    }

    const addModaltabs = [
      {id: 'general', displayName: "General", index: 0, content:  <UserAddGeneralTab handleAddChange={handleAddChange} /> }
    ]

    const openModal = () => {
        setIsOpen(true)
    }

    const closeModal = () => {
        setIsOpen(false)
    }

    const setFilteredRows = (filteredList) => {
        setRowList(filteredList)
    }

    useEffect (() => {
      async function fetchData() {
        // You can await here
        await RestCaller().makeRequest(USER_URI).then((data) =>{
            console.log(data)
            let dataList = data['_embedded']['userDataList']
            setDefaultRowList(dataList)
            setRowList(dataList)
            setAddLink(data["_links"]["create"])
        });
      }
      fetchData()
    }, [])

    return (
    <div>
        <h1> User</h1>
        <SearchBar defaultRowList={defaultRowList} getFilteredRows={setFilteredRows} filterBy={filterBy}/>
        <Button variant="contained" onClick={openModal}> Add</Button>  
        <AddModal show={isOpen} tabs={addModaltabs} actionLink={addLink} payLoad={newUser} handleModalClose={closeModal}/>
        <BasicTable columns={columns} rows={rowList}/>
     </div> 
    );
}
