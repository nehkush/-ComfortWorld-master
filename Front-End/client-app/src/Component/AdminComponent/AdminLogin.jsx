import React, { useState } from 'react';
import axios from 'axios';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import { useLocation, useNavigate } from 'react-router-dom';

const AdminLogin = ({ isLoggedIn, setIsLoggedIn, setAdmin }) => {
  const location = useLocation();
  const navigate = useNavigate(); // Using useNavigate hook to navigate
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    try {
      const response = await axios.post('http://localhost:8080/Admin/byEmail', { email, password });
      const admin = response.data;
      if (admin) {
        setMessage('Sign-in successful!');
        setIsLoggedIn(true);
        setAdmin(admin); // Set the user object
        // Redirect to home page upon successful login
        navigate('/adminhome');
      } else {
        setMessage('Invalid email or password. Please try again.');
      }
    } catch (error) {
      console.error('Error occurred:', error);
      setMessage('An error occurred. Please try again later.');
    }
  };

  return (
    <div
      className="admin-login-container"
      style={{
        backgroundImage: `url('https://source.unsplash.com/1920x1080/?nature')`, // Replace with your desired background image URL
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '100vh',
        padding: '50px',
      }}
    >
      <Container className="mt-5" style={{ borderRadius: '10px' }}>
        <h1 className="card-title text-center mb-4" style={{ backgroundColor: 'rgba(255, 255, 255, 0.8)', color: 'blue', padding: '10px' }}>Admin Portal</h1>
        <Row className="justify-content-center">
          <Col md={6}>
            <Form onSubmit={handleSubmit} className="border p-4" style={{ backgroundColor: 'rgba(255, 255, 255, 0.8)' }}>
              <h2 className="text-center mb-4">Login</h2>
              {message && <div className="alert alert-info">{message}</div>}
              <Form.Group controlId="formEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control
                  type="email"
                  placeholder="Enter email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
              </Form.Group>
              <Form.Group controlId="formPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
              </Form.Group>
              <Button variant="primary" type="submit" className="w-100">
                Submit
              </Button>
            </Form>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default AdminLogin;
