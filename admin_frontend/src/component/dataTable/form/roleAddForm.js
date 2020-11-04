import React from 'react';

import TextField from '@material-ui/core/TextField';

const RoleAddGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="name" label="Name" onChange={props.handleAddChange} />
    </form>
    )
}

export {RoleAddGeneralTab}