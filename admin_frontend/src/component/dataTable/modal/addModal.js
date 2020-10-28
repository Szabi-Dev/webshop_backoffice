import React from 'react';
import SimpleModal from '../common/simpleModal';
import TabComponent from '../common/tabComponent';

export default function AddModal(props){

    const body = (
        <TabComponent />
    )

    return (
        <SimpleModal show={props.show} handleModalClose={props.handleModalClose} title="Add new" body={body} />
    )
}

