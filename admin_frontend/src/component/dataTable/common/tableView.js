import React, { useState } from 'react';
import BasicTable from './table'

import SearchBar from './searchBar' 
import AddModal from '../modal/addModal';


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
            <AddModal show={isOpen} handleModalClose={closeModal} />
            <BasicTable columns={props.columns} rows={rowList}/>
        </div>
    );
}