import React, { useEffect, useState } from 'react';
import {RestCaller} from '../../services/util/restCaller';
import {USER_URI} from '../../services/util/constants'
import {UserAddGeneralTab, UserRolesTab} from '../dataTable/form/userAddForm'
import SearchBar from '../dataTable/common/searchBar' 
import AddModal from '../dataTable/modal/addModal'
import BasicTable from '../dataTable/common/table'
import Button from '@material-ui/core/Button';
import { UserEditGeneralTab, UserEditRolesTab } from '../dataTable/form/userEditForm';

const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'firstName', headerName: 'First name'},
    { field: 'lastName', headerName: 'Last name' },
    { field: 'email', headerName: 'Email' }
  ];
  

const filterBy= ["lastName", "firstName", "id", "email"]

export default function UserPage(){
    const [rowList, setRowList] = React.useState([]);
    const [defaultRowList, setDefaultRowList] = React.useState([]);
    const [isOpen, setIsOpen] = React.useState(false);
    const [addLink, setAddLink] = React.useState("")
    const [newUser, setNewUser] = React.useState({})
    
    const handleAddChange = (event) =>{
        newUser[event.target.name] = event.target.value
        setNewUser(newUser)
    }

    const handleRequests = (requests) => {
        if (!newUser.hasOwnProperty('requests')) {
            newUser.requests = {}
        }
        Object.assign( newUser.requests, requests )
        console.log(newUser)
    }

    const handleComplexObjectList = (objectList) => {
        Object.assign(newUser, objectList )
    }

    const addModaltabs = [
      {id: 'general', displayName: "General", index: 0, content:  <UserAddGeneralTab handleAddChange={handleAddChange} currentItem={newUser} /> },
      {id: 'roles', displayName: "Roles", index: 1, content:  <UserRolesTab addRequest={handleRequests} currentItem={newUser} handleComplexObject={handleComplexObjectList}  /> }
    ]

    const editModaltabs = [
        {id: 'general', displayName: "General", index: 0, content:  <UserEditGeneralTab /> },
        {id: 'roles', displayName: "Roles", index: 1, content:  <UserEditRolesTab /> }
      ]

    const openModal = () => {
        setIsOpen(true)
    }

    const closeModal = () => {
        setIsOpen(false)
        setNewUser({})
        fetchData()
    }

    const setFilteredRows = (filteredList) => {
        setRowList(filteredList)
    }
    
    async function fetchData() {
        // You can await here
        await RestCaller().makeRequest(USER_URI).then((data) =>{
            let dataList
            if ('_embedded' in data) {
                dataList = data['_embedded']['userDataList']
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
        <h1> User</h1>
        <SearchBar defaultRowList={defaultRowList} getFilteredRows={setFilteredRows} filterBy={filterBy}/>
        <Button variant="contained" onClick={openModal}> Add</Button>  
        <AddModal show={isOpen} tabs={addModaltabs} actionLink={addLink} payLoad={newUser} handleModalClose={closeModal}/>
        <BasicTable columns={columns} rows={rowList} handleResponse={fetchData} editTabs={editModaltabs} />
     </div> 
    );
}

