const validateMicrowaveForm = (data) => {
  let errors = {};

  // Validate brand
  if (!data.brand.trim()) {
    errors.brand = "Brand is required";
    data.brand !="";
    errors.brand="Only String value required"
  }

  // Validate model
  if (!data.model.trim()) {
    errors.model = "Model is required";
  }

  // Validate capacity
  if (!data.capacity.trim()) {
    errors.capacity = "Capacity is required";
  } else if (isNaN(data.capacity) || data.capacity <= 0) {
    errors.capacity = "Invalid capacity value";
  }

  // Validate price
  if (!data.price.trim()) {
    errors.price = "Price is required";
  } else if (isNaN(data.price) || data.price <= 0) {
    errors.price = "Invalid price value";
  }

  // Validate isUnderWarranty
  if (!data.isUnderWarranty.trim()) {
    errors.isUnderWarranty = "Warranty status is required";
  }

  // Validate isServiceRequired
  if (!data.isServiceRequired.trim()) {
    errors.isServiceRequired = "Service status is required";
  }

  return {
    isValid: Object.keys(errors).length === 0,
    errors,
  };
};

export default validateMicrowaveForm;
