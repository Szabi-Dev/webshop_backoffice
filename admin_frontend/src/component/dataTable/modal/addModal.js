import React from 'react';
import SimpleModal from '../common/simpleModal';
import TabComponent from '../common/tabComponent';
import Button from '@material-ui/core/Button';
import RestButton from '../common/restButton'

export default function AddModal(props){

    const body = (
        <TabComponent tabs={props.tabs}/>
    )

    const footer =(
        <div>
            <RestButton name="Add" actionLink={props.actionLink} action="POST" payLoad={props.payLoad} handleResponse={props.handleModalClose} />
            <Button variant="contained" onClick={props.handleModalClose}>Cancel</Button>
        </div>
    )

    return (
        <SimpleModal show={props.show} handleModalClose={props.handleModalClose} title="Add new" body={body} footer={footer}/>
    )
}

