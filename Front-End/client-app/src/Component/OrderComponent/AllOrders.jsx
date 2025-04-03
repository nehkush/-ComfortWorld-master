import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AllOrders = () => {
  const [orders, setOrders] = useState([]);
  const url = "http://localhost:8080";

  useEffect(() => {
    // Fetch data from the backend
    axios.get(`${url}/orders`)
      .then(response => {
        setOrders(response.data); // Assuming the backend response contains an array of orders
      })
      .catch(error => {
        console.error('Error fetching orders:', error);
      });
  },[]);


  return (
    <div className="container">
      <h2 className="my-4">Orders</h2>
      <div className="table-responsive">
        <table className="table table-striped table-bordered">
          <thead className="thead-dark">
            <tr>
              <th>Order Number</th>
              <th>Order Date</th>
              <th>Name</th>
              <th>Address</th>
              <th>State</th>
              <th>Pincode</th>
              <th>City</th>
              <th>Country</th>
              <th>Mobile Number</th>
              <th>Product Category</th>
              <th>Issue Description</th>
              <th>Payment</th>
            </tr>
          </thead>
          <tbody>
            {orders.map(order => (
              <tr key={order.id}>
                <td>{order.orderNumber}</td>
                <td>{order.orderDateTime}</td>
                <td>{order.name}</td>
                <td>{order.address}</td>
                <td>{order.state}</td>
                <td>{order.pincode}</td>
                <td>{order.city}</td>
                <td>{order.country}</td>
                <td>{order.mobileNumber}</td>
                <td>{order.productCategory}</td>
                <td>{order.issueDescription}</td>
                <td>{order.payment}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default AllOrders;
