// validation.js

export const validateUsername = (username) => {
  const regex = /^[a-zA-Z\s]+$/;
  return regex.test(username);
};

export const validateEmail = (email) => {
  // You can use a more comprehensive email validation regex
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
};

export const validatePhoneNumber = (phoneNumber) => {
  // You can customize the regex based on your requirements
  const regex = /^[0-9]{10}$/;
  return regex.test(phoneNumber);
};

export const validateAge = (age) => {
  const regex = /^[0-9]+$/;
  return regex.test(age);
};

export const validateAddress = (address) => {
  // You can customize the regex based on your requirements
  const regex = /^[a-zA-Z0-9\s,'-]*$/;
  return regex.test(address);
};

export const validatePassword = (password) => {
  // You can add more password criteria based on your requirements
  return password.length >= 6;
};
