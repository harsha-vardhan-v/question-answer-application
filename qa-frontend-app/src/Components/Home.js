import React from "react"
import Searchbar from "./Searchbar"
import QuestionsList from "./QuestionsList"

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

            <QuestionsList></QuestionsList>
            
        </div>
    )
}

export default Home