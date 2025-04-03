const validateBrand = (brand) => {
  const regex = /^[a-zA-Z\s]+$/;
  return regex.test(brand.trim());
};

const validateModel = (model) => {
  return model.trim() !== "";
};

const validateType = (type) => {
  return type.trim() !== "";
};

const validateCapacity = (capacity) => {
  const regex = /^[0-9]+$/;
  return regex.test(capacity.trim());
};

const validateHasRemoteControl = (hasRemoteControl) => {
  return hasRemoteControl.trim() !== "";
};

const validatePrice = (price) => {
  const regex = /^[0-9]+$/;
  return regex.test(price.trim());
};

const validateIsUnderWarranty = (isUnderWarranty) => {
  return isUnderWarranty.trim() !== "";
};

const ACRepairValidation = (data) => {
  const errors = {};

  if (!validateBrand(data.brand)) {
    errors.brand = "Brand should contain only letters";
  }

  if (!validateModel(data.model)) {
    errors.model = "Model is required";
  }

  if (!validateType(data.type)) {
    errors.type = "Type is required";
  }

  if (!validateCapacity(data.capacity)) {
    errors.capacity = "Capacity should contain only numbers";
  }

  if (!validateHasRemoteControl(data.hasRemoteControl)) {
    errors.hasRemoteControl = "Please select if it has remote control";
  }

  if (!validatePrice(data.price)) {
    errors.price = "Price should contain only numbers";
  }

  if (!validateIsUnderWarranty(data.isUnderWarranty)) {
    errors.isUnderWarranty = "Please select warranty status";
  }

  return { isValid: Object.keys(errors).length === 0, errors };
};

export default ACRepairValidation;