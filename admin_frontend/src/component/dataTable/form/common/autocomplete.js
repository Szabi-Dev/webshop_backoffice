import React from 'react';

import TextField from '@material-ui/core/TextField';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';

import ListItemText from '@material-ui/core/ListItemText';
import Autocomplete from '@material-ui/lab/Autocomplete';
import Button from '@material-ui/core/Button';

export default function FormManyToMany(props){
    
    const [newDataSet, setNewDataSet] = React.useState(props.currentDataSet)
    const [value, setValue] = React.useState({})
  

    const handleRemove = ( data) => {
        newDataSet.pop(data)
        setNewDataSet([...newDataSet])
        props.createRequests(data, 'DELETE')
        props.populateNewDataset(newDataSet)
      }
    
    const onChange = (event, newValue) => {
        setValue(newValue); 
    }

    const handleAdd = (data) => {
        if (newDataSet.includes(data) || data === undefined || data == null) {
            return;
        }
        newDataSet.push(data)
        setNewDataSet([...newDataSet])
        props.createRequests(data, 'PATCH')
        props.populateNewDataset(newDataSet)
    }
    
    return (
       <div>
            <Autocomplete id="combo-box" options={props.alldataList} getOptionLabel={(option) => option[props.optionLabel]} renderInput={(params) => <TextField {...params} label="Combo box" variant="outlined" />}  
                value={value} onChange={ onChange}/>
            <Button onClick={() => handleAdd(value)}> + </Button>
            
            <List>
                {newDataSet.map( (data, i) => (
                <ListItem>
                    <ListItemText primary={data.name} key={data}/>
                    <Button onClick={() => handleRemove(data)}> - </Button>
                </ListItem>
                    ) 
                )}
            </List>
      </div> )
}