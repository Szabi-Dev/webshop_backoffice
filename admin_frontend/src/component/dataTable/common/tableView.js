import React, { useState } from 'react';
import BasicTable from './table'

import SearchBar from './searchBar' 
import SimpleModal from './simpleModal';


export default function TableView(props){
    const [rowList, setRowList] = React.useState([]);
    const [rowListDefault, setRowListDefault] = React.useState([]);
    

    const fetchData = async () => {
        setRowList(props.data)
        setRowListDefault(props.data)
    }

    const setFilteredRows = (filteredList) => {
        setRowList(filteredList)
    }

    React.useEffect ( () => {fetchData()},[]);

    return (
        <div>
            <h1> {props.title}</h1>
            <SearchBar defaultRowList={rowListDefault} getFilteredRows={setFilteredRows} filterBy={props.filterBy}/>
            <SimpleModal buttonText="Add new" title="Add new"/>
            <BasicTable columns={props.columns} rows={rowList}/>
        </div>
    );
}