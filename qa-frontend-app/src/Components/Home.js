import React from "react"
import Searchbar from "./Searchbar"

const Home = () => {
    return (
        <div>
            <header style={{
                backgroundColor: '#ededed',
                padding: '1em',
                boxShadow: '0 1px 2px #ededed'
            }}>
                <Searchbar></Searchbar>
            </header>
            
        </div>
    )
}

export default Home