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
          {props.tabs.map( (tab) => (
              <Tab label={tab.displayName}  />
          ))}
        </Tabs>
        {props.tabs.map( (tab) => (
              <TabPanel value={value} index={tab.index} content={tab.content}/>
          ))}
        </div>  
    )

}