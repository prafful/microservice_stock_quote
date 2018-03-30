import React from "react";
import ReactDOM from "react-dom";

import axios from "axios";



class Profile extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            username:'',
            stock:'',
        
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(event){
        event.preventDefault();
        const state = this.state;
        state[event.target.name] = event.target.value;
        console.log(state[event.target.name]); 
        this.setState(state);

    }

    onSubmit(event){
        event.preventDefault();
        const { username, stock} = this.state;
        axios.get('http://localhost:8080/api/yahoo-service/rest/getyahoo/' + this.state.username,)
                .then((response)=>{
                                    console.log(response.data)
                                    console.log("GET Success!")
                                });
    }



    render(){
        return(
            <div>
                <h1> Profile</h1>
    
            <p> It was popularised in the 1960s
                 with the release of Letraset
                  sheets containing Lorem Ipsum
                   passages.</p>
                   <ul> 
                    <li>Home </li>
                    <li> Friends </li>
                    <li> Profile</li>
                </ul>

                <h3>Stock Quote</h3>
                <form onSubmit={this.onSubmit}>
                    Name: <input type="text" name="username" value={this.state.username} onChange={this.onChange} /><br></br>
                    Stock: <input type="text" name="stock" value={this.state.stock} onChange={this.onChange} />
                  
                    <button type="submit">Get Quote</button>
                </form>
            

            </div>    

        );
    }

}

export default Profile;