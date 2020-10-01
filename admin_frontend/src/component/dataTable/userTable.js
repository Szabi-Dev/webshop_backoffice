import React from 'react';
import BasicTable from './table'

import SearchBar from './searchBar' 

const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'firstName', headerName: 'First name'},
    { field: 'lastName', headerName: 'Last name' },
    { field: 'age', headerName: 'Age', type: 'number' }
  ];
  
  const rows = [
    { id: 1, lastName: 'Snow', firstName: 'Jon', age: 35 },
    { id: 2, lastName: 'Lannister', firstName: 'Cersei', age: 42 },
    { id: 3, lastName: 'Lannister', firstName: 'Jaime', age: 45 },
    { id: 4, lastName: 'Stark', firstName: 'Arya', age: 16 },
    { id: 5, lastName: 'Targaryen', firstName: 'Daenerys', age: null },
    { id: 6, lastName: 'Melisandre', firstName: null, age: 150 },
    { id: 7, lastName: 'Clifford', firstName: 'Ferrara', age: 44 },
    { id: 8, lastName: 'Frances', firstName: 'Rossini', age: 36 },
    { id: 9, lastName: 'Roxie', firstName: 'Harvey', age: 65 },
  ];


export default function UserTable(){
    const [input, setInput] = React.useState("");
    const [rowList, setRowList] = React.useState([]);
    const [rowListDefault, setRowListDefault] = React.useState([]);

    const fetchData = async () => {
        setRowList(rows)
        setRowListDefault(rows)
    }
    
    const updateInput = async (e) => {
        const value = e.target.value
        
        const filtered = rowListDefault.filter (row => {
            return row.lastName.includes(value)
        })
        setInput(value)
        setRowList(filtered)
    }


    React.useEffect ( () => {fetchData()},[]);

    return (
        <div>
            <h1> User</h1>
            <input type="text" value={input} onChange={updateInput} placeholder="Search" />
            <BasicTable columns={columns} rows={rowList}/> 
        </div>
    );
}

