import React, { useEffect, useState } from 'react';
import {UserService} from '../../services/userService';
import TableView from './common/tableView'
import Input from '@material-ui/core/Input';

const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'firstName', headerName: 'First name'},
    { field: 'lastName', headerName: 'Last name' },
    { field: 'email', headerName: 'Email' }
  ];
  

  const filterBy= ["lastName", "firstName", "id", "age"]


  const addModaltabs = [
    {id: 'tab1', displayName: "Tab 1", index: 0, content:  <Input type="text" placeholder="tab1"/>}
]


export default function UserTable(){
    const [rows, setRows] = useState([])

    const userService = UserService(); 

    useEffect (() => {
      async function fetchData() {
        // You can await here
        await userService.fetchUsers().then(setRows);
      }
      fetchData()
    }, [])

    return (
        <TableView data={rows} columns={columns} addModalTabs={addModaltabs} filterBy={filterBy} title="User" />
    );
}

