import React from "react";
import ReactDOM from "react-dom";

import FetchFriends from "./FetchFriendsFromSpringBoot/FetchFriends";

class Friends extends React.Component{
    render(){
        return(
            <div>
                <h1> Friends</h1>
    <p>  Lorem Ipsum is simply dummy text of 
        the printing and typesetting industry. 
        Lorem Ipsum has been the industry's 
        standard dummy text ever since the 1500s, 
        when an unknown printer took a galley of
            type and scrambled it to make a type 
            specimen book. It has survived not only
            five centuries, but also the leap into
            electronic typesetting, remaining 
            essentially unchanged. </p> 
            <p> It was popularised in the 1960s
                 with the release of Letraset
                  sheets containing Lorem Ipsum
                   passages, and more recently
                    with desktop publishing 
                    software like Aldus 
                    PageMaker including version
                    s of Lorem Ipsum.



</p>
              <FetchFriends></FetchFriends> 
            

            </div>    

        );
    }

}

export default Friends;