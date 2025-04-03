// OrderForm.js

const validateOrderForm = (data) => {
  const errors = {};

  // Validate each field as needed
  if (!data.name.trim()) {
    errors.name = "Name is required";
  } else if (!/^[a-zA-Z\s]+$/.test(data.name.trim())) {
    errors.name = "Name should contain only letters";
  }

  if (!data.mobileNumber.trim()) {
    errors.mobileNumber = "Mobile Number is required";
  } else if (!/^[0-9]{10}$/.test(data.mobileNumber.trim())) {
    errors.mobileNumber = "Enter a valid 10-digit Mobile Number";
  }

  if (!data.address.trim()) {
    errors.address = "Address is required";
  }

  if (!data.city.trim()) {
    errors.city = "City is required";
  }

  if (!data.state.trim()) {
    errors.state = "State is required";
  }

  if (!data.pincode.trim()) {
    errors.pincode = "Pincode is required";
  } else if (!/^[0-9]{6}$/.test(data.pincode.trim())) {
    errors.pincode = "Enter a valid 6-digit Pincode";
  }

  if (!data.productCategory.trim()) {
    errors.productCategory = "Product Category is required";
  }

  if (!data.payment.trim()) {
    errors.payment = "Payment Method is required";
  }

  if (!data.issueDescription.trim()) {
    errors.issueDescription = "Issue Description is required";
  }

  return { isValid: Object.keys(errors).length === 0, errors };
};

export default validateOrderForm;
