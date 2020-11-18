import React from 'react';

import TextField from '@material-ui/core/TextField';
import { PRIVILEGE_URI, ROLE_PRIVILEGE_URI } from '../../../services/util/constants';

import { RestCaller } from '../../../services/util/restCaller';
import FormManyToMany from './common/autocomplete';
import { CompexObjectRequestHandler } from '../../../services/ComplexObjectRequestHandler';

const RoleAddGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="name" label="Name" onChange={props.handleAddChange} />
    </form>
    )
}

const RoleAddPrivilegeTab  = (props) => {
    const [alldataList, setAllDataList] = React.useState([])
  
    
    const populateNewDataset = (newDataset) => {
          let data = { "privileges" : newDataset }
          let requests = CompexObjectRequestHandler().getRequests(newDataset, [], ROLE_PRIVILEGE_URI , "{privilegeId}")
          props.addRequest({"privilege" : requests})
          props.handleComplexObject(data)
  
    }
  
    async function fetchData() {
      await RestCaller().makeRequest(PRIVILEGE_URI).then((data) =>{
          let dataList
          if ('_embedded' in data) {
              dataList = data['_embedded']['privilegeDataList']
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
  

export {RoleAddGeneralTab, RoleAddPrivilegeTab}