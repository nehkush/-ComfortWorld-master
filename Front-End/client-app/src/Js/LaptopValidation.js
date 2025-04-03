// LaptopValidation.js

const validateForm = (data) => {
  let errors = {};

  // Validation logic for each field
  if (!data.brand) {
    errors.brand = "Brand is required";
  }

  if (!data.model) {
    errors.model = "Model is required";
  }

  // Add more validation rules for other fields as needed

  return {
    isValid: Object.keys(errors).length === 0,
    errors,
  };
};

export default validateForm;
