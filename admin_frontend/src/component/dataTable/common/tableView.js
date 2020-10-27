import React, { useState } from 'react';
import BasicTable from './table'

import SearchBar from './searchBar' 
import SimpleModal from './simpleModal';


export default function TableView(props){
    const [rowList, setRowList] = React.useState([]);
    const [rowListDefault, setRowListDefault] = React.useState([]);
    const [isOpen, setIsOpen] = React.useState(false);
    
    const openModal = () => {
        setIsOpen(true)
    }

    const closeModal = () => {
        setIsOpen(false)
    }

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
            <button onClick={openModal}> Add new</button>
            <SimpleModal show={isOpen} handleModalClose={closeModal} title="Add new"/>
            <BasicTable columns={props.columns} rows={rowList}/>
        </div>
    );
}