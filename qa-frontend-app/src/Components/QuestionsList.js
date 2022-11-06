import React, {useState, useEffect} from 'react'
import axios from 'axios'

const cardStyle = {
    padding: '1em',
    backgroundColor: '#ededed',
}

const QuestionsList = () => {
    const [questions, setQuestions] = useState([])

    useEffect(() => {
        const fetchData = async () => {
            const questionsReturn = await axios.get('http://localhost:8080/api/questions')
            setQuestions(questionsReturn.data.content)
        }

        fetchData()
    }, [questions])

    return (
        <div style={{
            margin: '2em auto 2em auto',
            width: '60%',
        }}>
            {questions.map(question => {
                return (
                    <div key={question.id} style={cardStyle}>
                        <h3><a href='#' style={{color: '#545557'}}>{question.title}</a></h3>
                        <p>{question.description}</p>
                    </div>
                )
            })}
        </div>
    )
}

export default QuestionsList