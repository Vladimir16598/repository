import React, {Component} from 'react';
import {View,Text} from 'react-native';
import firebase from 'firebase';
import {Header, Button, Spinner} from './components/common';
import LoginForm from './components/LoginForm';


class App extends Component {
    state = {loggedIn:null};

    componentWillMount() {
        firebase.initializeApp({
            apiKey: 'AIzaSyD35pFo-a5xu7X6X8NaSqjYCuhqXXP3ARk',
            authDomain: 'authentication-526b6.firebaseapp.com',
            databaseURL: 'https://authentication-526b6.firebaseio.com',
            projectId: 'authentication-526b6',
            storageBucket: 'authentication-526b6.appspot.com',
            messagingSenderId: '212539565061'
        });

        firebase.auth().onAuthStateChanged((user)=>{
            if (user) {
                this.setState({loggedIn: true});
            }
            else {
                this.setState({loggedIn:false});
            }
        });
    }
    renderContent() {
        switch(this.state.loggedIn){
            case true:
                return (
                    <Button onPress ={() => firebase.auth().signOut()}>
                        Log Out</Button>
            );
            case false:
                return <LoginForm/>;
            default:
                return <Spinner size="large"/>;
        }
    }
    render () {
        return (
            <View>
                <Header headerText="Authenthication"/>
                {this.renderContent()}
            </View>
        )
    }
}

export default App;