// validateLoginForm.js

export const validateEmail = (email) => {
  const isValid = /^\S+@\S+\.\S+$/.test(email);
  const message = isValid ? "" : "Invalid email address. Please enter a valid email.";
  return { isValid, message };
};

export const validatePassword = (password) => {
  const isValid = password.length >= 6;
  const message = isValid ? "" : "Invalid password. Password must be at least 6 characters long.";
  return { isValid, message };
};
