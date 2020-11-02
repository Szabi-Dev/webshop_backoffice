import React from 'react';
import SimpleModal from '../common/simpleModal';
import TabComponent from '../common/tabComponent';
import Button from '@material-ui/core/Button';


export default function AddModal(props){

    const body = (
        <TabComponent tabs={props.tabs}/>
    )

    const footer =(
        <div>
            <Button variant="contained">Add</Button> 
            <Button variant="contained" onClick={props.handleModalClose}>Cancel</Button>
        </div>
      
    )

    return (
        <SimpleModal show={props.show} handleModalClose={props.handleModalClose} title="Add new" body={body} footer={footer}/>
    )
}

