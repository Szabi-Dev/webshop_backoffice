import React from 'react';

import TextField from '@material-ui/core/TextField';
import { PRIVILEGE_URI, ROLE_PRIVILEGE_URI } from '../../../services/util/constants';

import FormManyToMany from './common/autocomplete';
import { CompexObjectRequestHandler } from '../../../services/ComplexObjectRequestHandler';

import { RestCaller } from '../../../services/util/restCaller';

const RoleEditGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="name" defaultValue={props.currentItem.name} label="Name" onChange={props.handleEditChange} />
    </form>
    )
}

const RoleEditPrivilegesTab  = (props) => {
    const [alldataList, setAllDataList] = React.useState([])
    const [currentItem, setCurrentItem] = React.useState(props.currentItem)
    const [initialPrivs, setInitialPrivs] = React.useState([])
    const [currentPrivs, setCurrentPrivs] = React.useState([])

    const populateNewDataset = (newDataset) => {
        let requests = CompexObjectRequestHandler().getRequests(newDataset, initialPrivs, ROLE_PRIVILEGE_URI, "{privilegeId}")
        Object.assign(currentItem, { "privileges" : newDataset}  )
        Object.assign(currentItem, {"requests" : requests})

        setCurrentItem(currentItem)
        setCurrentPrivs([...newDataset])
        props.addRequest({"privilege" : requests})
        
        props.handleComplexObject({ "privileges" : newDataset})
    }

    async function fetchAllData() {
      await RestCaller().makeRequest(PRIVILEGE_URI).then((data) =>{  
        if ('_embedded' in data) {
            alldataList.push(... data['_embedded']['privilegeDataList'])
          } 
          setAllDataList([...alldataList])
          
      });
      
    }

    async function fetchPrivsForCurrentItem() {
      await RestCaller().makeRequest(props.currentItem["_links"]["privileges"]["href"]).then((data) =>{      
        if ('_embedded' in data) {
                initialPrivs.push( ...data['_embedded']['privilegeDataList'] )
                currentPrivs.push(...data['_embedded']['privilegeDataList'])
                setInitialPrivs([...initialPrivs])
                setCurrentPrivs([...currentPrivs])
            }             
      });
    }
    React.useEffect (() => { fetchAllData() }, [])
   
    React.useEffect (() => { fetchPrivsForCurrentItem() }, [])
    
    return (
        <FormManyToMany alldataList={alldataList} optionLabel="name" populateNewDataset={populateNewDataset}  currentDataSet={ currentItem.hasOwnProperty('privileges') ? currentItem.privileges : currentPrivs  } />
      )
  }

export {RoleEditGeneralTab, RoleEditPrivilegesTab}