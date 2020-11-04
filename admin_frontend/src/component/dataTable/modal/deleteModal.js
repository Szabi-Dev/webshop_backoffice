import React from 'react';
import SimpleModal from '../common/simpleModal';
import Button from '@material-ui/core/Button';
import RestButton from '../common/restButton'


const deleteModalBody = {
    text: "Are you sure you want to delete this item?"
}


export default function DeleteModal(props){


    const footer =(
        <div>
            <RestButton name="Delete" actionLink={props.actionLink} action="DELETE" handleResponse={props.handleModalClose} />
            <Button variant="contained" onClick={props.handleModalClose}>Cancel</Button>
        </div>
    )

    return (
        <SimpleModal show={props.show} handleModalClose={props.handleModalClose} title="Delete item" body={deleteModalBody.text} footer={footer}/>
    )
}