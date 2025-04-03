const validateWashingMachineForm = (data) => {
  const errors = {};

  // Validate brand
  if (!data.brand.trim()) {
    errors.brand = "Brand is required";
  }

  // Validate model
  if (!data.model.trim()) {
    errors.model = "Model is required";
  }

  // Validate type
  if (!data.type.trim()) {
    errors.type = "Type is required";
  }

  // Validate capacity
  if (!data.capacity.trim()) {
    errors.capacity = "Capacity is required";
  } else if (isNaN(data.capacity) || data.capacity <= 0) {
    errors.capacity = "Invalid capacity. Please enter a valid number greater than 0";
  }

  // Validate hasDryer
  if (!data.hasDryer.trim()) {
    errors.hasDryer = "Please select whether the washing machine has a dryer";
  }

  // Validate price
  if (!data.price.trim()) {
    errors.price = "Price is required";
  } else if (isNaN(data.price) || data.price <= 0) {
    errors.price = "Invalid price. Please enter a valid number greater than 0";
  }

  // Validate isUnderWarranty
  if (!data.isUnderWarranty.trim()) {
    errors.isUnderWarranty = "Please select whether the washing machine is under warranty";
  }

  return {
    isValid: Object.keys(errors).length === 0,
    errors,
  };
};

export default validateWashingMachineForm;
