import React from 'react';

import TextField from '@material-ui/core/TextField';

import Autocomplete from '@material-ui/lab/Autocomplete';

import { RestCaller } from '../../../services/util/restCaller';
import { ROLE_URI } from '../../../services/util/constants';

const UserAddGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="firstName" label="First Name" onChange={props.handleAddChange} />
       <TextField id="standard-basic" name="lastName" label="Last Name" onChange={props.handleAddChange} />
       <TextField id="standard-basic" name="email" label="E-mail" onChange={props.handleAddChange} />
       <TextField id="standard-password-input" name="password" label="Password" type="password" onChange={props.handleAddChange} />
    </form>
    )
}


const UserRolesTab  = (props) => {
  const [dataList, setDataList] = React.useState([])

  async function fetchData() {
    // You can await here
    await RestCaller().makeRequest(ROLE_URI).then((data) =>{
        let dataList
        if ('_embedded' in data) {
            dataList = data['_embedded']['roleDataList']
        } else {
            dataList = []
        }
        
        setDataList(dataList)
    });
  }

  React.useEffect (() => { fetchData() }, [])
  
  return (
      <div>
        <Autocomplete id="combo-box" options={dataList} getOptionLabel={(option) => option.name} renderInput={(params) => <TextField {...params} label="Combo box" variant="outlined" />}
      />
      </div>
    )
}

export {UserAddGeneralTab, UserRolesTab}