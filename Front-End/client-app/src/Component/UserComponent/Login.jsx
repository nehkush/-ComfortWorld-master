import React, { useState } from 'react';
import axios from 'axios';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import { useLocation, useNavigate } from 'react-router-dom';

const Login = ({ isLoggedIn, setIsLoggedIn, setUser }) => {
  const location = useLocation();
  const navigate = useNavigate(); // Using useNavigate hook to navigate
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    try {
      const response = await axios.post('http://localhost:8080/users/byEmail', { email, password });
      const user = response.data;
      if (user) {
        setMessage('Sign-in successful!');
        setIsLoggedIn(true);
        setUser(user); // Set the user object
        // Redirect to home page upon successful login
        navigate('/');
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
      className="login-container"
      style={{
        backgroundImage: `url('https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0')`, // Replace with your desired background image URL
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '100vh',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
      }}
    >
      <Container>
        <Row className="justify-content-center">
          <Col md={6}>
            <Form onSubmit={handleSubmit} className="border rounded p-4 shadow" style={{ background: 'rgba(255, 255, 255, 0.8)' }}>
              <h2 className="text-center mb-4">User Login</h2>
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
                /> <br></br>
              </Form.Group>
              <Button variant="primary" type="submit" className="w-100">
                Submit
              </Button>
            </Form>
            <div className="mt-3 text-center">
              <p>Forgot your password? <a href="#">Reset Password</a></p>
              <p>Don't have an account? <a href="/register">Register Now</a></p>
            </div>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default Login;
