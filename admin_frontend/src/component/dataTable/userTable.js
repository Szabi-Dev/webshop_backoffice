import React, { useEffect, useState } from 'react';
import {UserService} from '../../services/userService';
import TableView from './common/tableView'

const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'firstName', headerName: 'First name'},
    { field: 'lastName', headerName: 'Last name' },
    { field: 'email', headerName: 'Email' }
  ];
  

  const filterBy= ["lastName", "firstName", "id", "age"]

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
        <TableView data={rows} columns={columns} filterBy={filterBy} title="User" />
    );
}

