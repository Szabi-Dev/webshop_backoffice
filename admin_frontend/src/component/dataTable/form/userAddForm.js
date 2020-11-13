import React from 'react';

import TextField from '@material-ui/core/TextField';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';

import ListItemText from '@material-ui/core/ListItemText';
import Autocomplete from '@material-ui/lab/Autocomplete';
import Button from '@material-ui/core/Button';
import { RestCaller } from '../../../services/util/restCaller';
import { ROLE_URI } from '../../../services/util/constants';

const UserAddGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" defaultValue={props.currentItem.firstName} name="firstName" label="First Name" onChange={props.handleAddChange} />
       <TextField id="standard-basic" defaultValue={props.currentItem.lastName} name="lastName" label="Last Name" onChange={props.handleAddChange} />
       <TextField id="standard-basic" defaultValue={props.currentItem.email}name="email" label="E-mail" onChange={props.handleAddChange} />
       <TextField id="standard-password-input" defaultValue={props.currentItem.password} name="password" label="Password" type="password" onChange={props.handleAddChange} />
    </form>
    )
}


const UserRolesTab  = (props) => {
  const [alldataList, setAllDataList] = React.useState([])
  const [newDataSet, setNewDataSet] = React.useState([])
  const [value, setValue] = React.useState([])

  const handleRemove = ( data) => {
    newDataSet.pop(data)
    setNewDataSet([...newDataSet])
  }

  const onChange = (event, newValue) => {
    if (newDataSet.includes(newValue) || newValue === undefined || newValue == null) {
      return;
    }
    setValue(newValue);

    newDataSet.push(newValue)
    setNewDataSet(newDataSet)
  }

  async function fetchData() {
    await RestCaller().makeRequest(ROLE_URI).then((data) =>{
        let dataList
        if ('_embedded' in data) {
            dataList = data['_embedded']['roleDataList']
        } else {
            dataList = []
        }
        
        setAllDataList(dataList)
    });
  }

  React.useEffect (() => { fetchData() }, [])
  
  return (
      <div>
        <Autocomplete id="combo-box" options={alldataList} getOptionLabel={(option) => option["name"]} renderInput={(params) => <TextField {...params} label="Combo box" variant="outlined" />}  value={value} onChange={ onChange}/>
        <List>
          {newDataSet.map( (data, i) => (
            <ListItem>
              <ListItemText primary={data.name} key={data}/>
              <Button onClick={() => handleRemove(data)}> - </Button>
            </ListItem>
          ) 
          )}
          
        </List>
      </div>
    )
}

export {UserAddGeneralTab, UserRolesTab}