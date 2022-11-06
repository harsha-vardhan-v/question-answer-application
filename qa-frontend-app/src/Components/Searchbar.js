import React from "react"
import Button from 'react-bootstrap/Button'
import Form from "react-bootstrap/Form"
import {Row, Col} from 'react-bootstrap';

const Searchbar = () => {
    return (
        <Form style={{
                width: '80%',
                margin: 'auto',
        }}>
            <Row>
                <Col lg="10" md="8" sm="6" xs="4">
                    <Form.Control type="text" placeholder="Search for questions"></Form.Control>
                </Col>

                <Col>
                    <Button type="submit" style={{
                        backgroundColor: '#545557',
                        borderColor: '#545557',
                    }}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                        </svg>

                        <p style={{
                            display: 'inline',
                            marginLeft: '1em',
                        }}>
                            Search
                        </p>
                    </Button>
                </Col>
            </Row>
        </Form>
    )
}

export default Searchbar