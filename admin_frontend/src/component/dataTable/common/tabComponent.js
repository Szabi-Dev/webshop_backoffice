import React from 'react';

import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import TabPanel from '../common/tabPanel'

export default function TabComponent(props){
    const [value, setValue] = React.useState(0);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <div>
        <Tabs value={value} onChange={handleChange} aria-label="simple tabs example">
          <Tab label="Item One"  />
          <Tab label="Item Two" />
          <Tab label="Item three"/>
        </Tabs>
    
        <TabPanel value={value} index={0} content="one"/>
        <TabPanel value={value} index={1} content="two" />

        </div>  
    )

}