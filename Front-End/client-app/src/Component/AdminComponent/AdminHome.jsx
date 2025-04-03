import React from 'react';
import { Container, Row, Col, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const AdminHome = () => {
    return (
        <div className="bg-light" style={{ minHeight: '100vh', paddingTop: '50px' }}>
            <Container>
                <Row className="justify-content-center">
                    <Col md={6} className="text-center">
                        <h1>Welcome to Admin Portal</h1>
                        <p className="lead">Manage your application efficiently with our powerful admin tools.</p>
                    </Col>
                </Row>
                <Row className="mt-5">
                    <Col md={4} className="mb-4">
                        <div className="p-4 bg-white rounded shadow">
                            <h3 className="mb-3">Manage Users</h3>
                            <p>View, create, update, and delete user accounts.</p>
                            <Button variant="primary">Go to Users</Button>
                        </div>
                    </Col>
                    <Col md={4} className="mb-4">
                        <div className="p-4 bg-white rounded shadow">
                            <h3 className="mb-3">All Orders</h3>
                            <p>View, process, and manage orders placed by customers.</p>
                            <Link to="/allorders">
                            <Button variant="primary">Go to Orders</Button>

                            </Link>
                        </div>
                    </Col>
                    <Col md={4} className="mb-4">
                        <div className="p-4 bg-white rounded shadow">
                            <h3 className="mb-3">Manage Services</h3>
                            <p>View, create, update, and delete services offered by the application.</p>
                            <Button variant="primary">Go to Services</Button>
                        </div>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};

export default AdminHome;
