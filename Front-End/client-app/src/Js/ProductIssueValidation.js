// ProductIssueValidation.js

const validateCategory = (category) => {
  const regex = /^[a-zA-Z\s]+$/;
  return regex.test(category.trim());
};

const validateBrand = (brand) => {
  const regex = /^[a-zA-Z\s]+$/;
  return regex.test(brand.trim());
};

const validateModelNumber = (modelNumber) => {
  const regex = /^[0-9]{10}$/;
  return regex.test(modelNumber.trim());
};


const validateIssueDescription = (issueDescription) => {
  return issueDescription.trim() !== "";
};

const productIssueValidation = (data) => {
  const errors = {};

  if (!validateCategory(data.category)) {
    errors.category = "Category should contain only letters";
  }

  if (!validateBrand(data.brand)) {
    errors.brand = "Brand should contain only letters";
  }

  if (!validateModelNumber(data.modelNumber)) {
    errors.modelNumber = "Model Number is required with 10 digits";
  }

  if (!validateIssueDescription(data.issueDescription)) {
    errors.issueDescription = "Issue Description is required";
  }

  return { isValid: Object.keys(errors).length === 0, errors };
};

export default productIssueValidation;
