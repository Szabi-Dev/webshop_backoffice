import React, { useEffect, useState } from 'react';
import {RestCaller} from '../../services/util/restCaller';
import {USER_URI} from '../../services/util/constants'
import TableView from './common/tableView'
import {UserAddGeneralTab} from './form/userAddForm'

const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'firstName', headerName: 'First name'},
    { field: 'lastName', headerName: 'Last name' },
    { field: 'email', headerName: 'Email' }
  ];
  

const filterBy= ["lastName", "firstName", "id", "age"]



export default function UserTable(){
    const [userData, setUserData] = useState({})
    const newUser = {}

    const restCaller = RestCaller(); 

    const addModaltabs = [
      {id: 'general', displayName: "General", index: 0, content:  <UserAddGeneralTab /> }
    ]


    useEffect (() => {
      async function fetchData() {
        // You can await here
        await restCaller.makeRequest(USER_URI).then(setUserData);
      }
      fetchData()
    }, [])

    return (
        <TableView data={userData} columns={columns} addModalTabs={addModaltabs} filterBy={filterBy} title="User" />
    );
}

