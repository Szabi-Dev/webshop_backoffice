import React from 'react';

import SimpleModal from '../common/simpleModal';
import TabComponent from '../common/tabComponent';
import Button from '@material-ui/core/Button';
import RestButton from '../common/restButton'

export default function EditModal(props){
    const body = (
        <TabComponent tabs={props.tabs}/>
    )

    const footer =(
        <div>
            <RestButton name="Edit" actionLink={props.actionLink} action="PATCH" payLoad={props.payLoad} handleResponse={props.handleModalClose} />
            <Button variant="contained" onClick={props.handleModalClose}>Cancel</Button>
        </div>
    )

    return (
        <SimpleModal show={props.show} handleModalClose={props.handleModalClose} title="Edit" body={body} footer={footer}/>
    )
}