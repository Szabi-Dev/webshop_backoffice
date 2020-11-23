import React, { useEffect, useState } from 'react'
import SearchBar from '../dataTable/common/searchBar' 
import AddModal from '../dataTable/modal/addModal'
import BasicTable from '../dataTable/common/table'
import Button from '@material-ui/core/Button';
import {RestCaller} from '../../services/util/restCaller';
import { CATEGORY_URI } from '../../services/util/constants';




const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'code', headerName: 'Code'},
    { field: 'categoryName', headerName: 'Category Name'},
  ];
  
const filterBy= ["id", "code", "categoryName"]

export default function CategoryPage(){
    const [rowList, setRowList] = React.useState([]);
    const [defaultRowList, setDefaultRowList] = React.useState([]);
    const [isOpen, setIsOpen] = React.useState(false);
    const [addLink, setAddLink] = React.useState("")
    const [newCategory, setNewCategory] = React.useState({})
    
    const handleAddChange = (event) =>{
        newCategory[event.target.name] = event.target.value
        setNewCategory(newCategory)
    }
    
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
        await RestCaller().makeRequest(CATEGORY_URI).then((data) =>{
            let dataList
            if ('_embedded' in data) {
                dataList = data['_embedded']['categoryDataList']
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
        <h1> Category</h1>
        <SearchBar defaultRowList={defaultRowList} getFilteredRows={setFilteredRows} filterBy={filterBy}/>
        <BasicTable columns={columns} rows={rowList} handleResponse={fetchData} editTabs={[]} />
     </div> 
    );

}