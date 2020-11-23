import React from 'react';

import TextField from '@material-ui/core/TextField';

import { RestCaller } from '../../../services/util/restCaller';
import { ROLE_URI, USER_ROLE_URI } from '../../../services/util/constants';
import FormManyToMany from './common/autocomplete';
import { CompexObjectRequestHandler } from '../../../services/ComplexObjectRequestHandler';

const UserEditGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="firstName" defaultValue={props.currentItem.firstName} label="First Name" onChange={props.handleEditChange} />
       <TextField id="standard-basic" name="lastName" defaultValue={props.currentItem.lastName} label="Last Name" onChange={props.handleEditChange} />
       <TextField id="standard-basic" name="email" defaultValue={props.currentItem.email} label="E-mail" onChange={props.handleEditChange} />
    </form>
    )
}

const UserEditRolesTab  = (props) => {
    const [alldataList, setAllDataList] = React.useState([])
    const [currentItem, setCurrentItem] = React.useState(props.currentItem)
    const [initialRoles, setInitialRoles] = React.useState([])
    const [currentRoles, setCurrentRoles] = React.useState([])

    const populateNewDataset = (newDataset) => {
        let requests = CompexObjectRequestHandler().getRequests(newDataset, initialRoles, USER_ROLE_URI, "{roleId}")
        Object.assign(currentItem, { "roles" : newDataset}  )
        Object.assign(currentItem, {"requests" : requests})

        setCurrentItem(currentItem)
        setCurrentRoles([...newDataset])
        props.addRequest({"role" : requests})
        props.handleComplexObject({ "roles" : newDataset})
    }

    async function fetchAllData() {
      await RestCaller().makeRequest(ROLE_URI).then((data) =>{  
        if ('_embedded' in data) {
            alldataList.push(... data['_embedded']['roleDataList'])
          } 
          setAllDataList([...alldataList])
          
      });
      
    }

    async function fetchRolesForCurrentItem() {
      await RestCaller().makeRequest(props.currentItem["_links"]["roles"]["href"]).then((data) =>{      
        if ('_embedded' in data) {
                initialRoles.push( ...data['_embedded']['roleDataList'] )
                currentRoles.push(...data['_embedded']['roleDataList'])
                setInitialRoles([...initialRoles])
                setCurrentRoles([...currentRoles])
            }             
      });
    }
    React.useEffect (() => { fetchAllData() }, [])
   
    React.useEffect (() => { fetchRolesForCurrentItem() }, [])
    
    return (
        <FormManyToMany alldataList={alldataList} optionLabel="name" populateNewDataset={populateNewDataset}  currentDataSet={ currentItem.hasOwnProperty('roles') ? currentItem.roles : initialRoles  } />
      )
  }

export {UserEditGeneralTab, UserEditRolesTab}


