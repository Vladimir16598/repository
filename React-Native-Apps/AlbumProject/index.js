// Import libraries
import React from 'react';
import {Text,AppRegistry,View} from 'react-native';
import Header from './src/components/header';
import AlbumList from './src/components/AlbumList';
// create components

const App = () => (
    //  <Text>Some Text</Text>
    <View style = {{flex: 1}}>
        <Header headerText={'Albums!'} />
        <AlbumList />
    </View>

)


//Render
AppRegistry.registerComponent('AlbumProject', ()=> App)
//AppRegistry.registerComponent('AlbumProject', ()=> Header)


