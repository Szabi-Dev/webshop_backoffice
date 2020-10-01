import React from 'react';

import Input from '@material-ui/core/Input';

export default function SearchBar (props) {
    const [input, setInput] = React.useState("")

    const updateInput = async (e) => {
        const value = e.target.value
        setInput(value)
        filterRows(value)
    }
    
    const filterRows = async (value) => {
        const filteredList =  props.defaultRowList.filter (row => {
            return filterByAttributes(row, value)
        })
        props.getFilteredRows(filteredList)
    }

    const filterByAttributes = (row, keyWord) => {
        var found = false;
        props.filterBy.map (attr => { if ( filterStringAttr(row, attr, keyWord) ) found = true; } )
        return found
    }

    const filterStringAttr = (row, attribute, keyWord) => {
        if (row[attribute] == null ) return false;
        return String(row[attribute]).toLowerCase().includes(keyWord.toLowerCase())
    }
    
    return (
      <Input type = "text" value={input} onChange={updateInput} placeholder={"Search"} />
    );
  }
