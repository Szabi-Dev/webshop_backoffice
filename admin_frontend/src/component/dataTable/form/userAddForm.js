import React from 'react';

import TextField from '@material-ui/core/TextField';

import { RestCaller } from '../../../services/util/restCaller';
import { ROLE_URI, USER_ROLE_URI } from '../../../services/util/constants';
import FormManyToMany from './common/autocomplete';
import { CompexObjectRequestHandler } from '../../../services/ComplexObjectRequestHandler';

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

  
  const populateNewDataset = (newDataset) => {
        let data = { "roles" : newDataset }
        let requests = CompexObjectRequestHandler().getRequests(newDataset, [], USER_ROLE_URI, "{roleId}")
        props.addRequest({"role" : requests})
        props.handleComplexObject(data)

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
      <FormManyToMany alldataList={alldataList} optionLabel="name" populateNewDataset={populateNewDataset}  currentDataSet={ props.currentItem.hasOwnProperty('roles') ? props.currentItem.roles : []  } />
    )
}

export {UserAddGeneralTab, UserRolesTab}