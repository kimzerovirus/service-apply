import React, { useEffect } from "react";
import PropTypes from "prop-types";

import Field from "../Field/Field";
import Label from "../Label/Label";
import TextInput from "../TextInput/TextInput";
import useFormContext from "../../../hooks/useFormContext";

import styles from "./BirthField.module.css";

const BirthField = ({ required }) => {
  const { value, errorMessage, handleChange, register, unRegister } =
    useFormContext();

  useEffect(() => {
    register("year");
    register("month");
    register("day");

    return () => {
      unRegister("year");
      unRegister("month");
      unRegister("day");
    };
  }, []);

  return (
    <>
      <Field className={styles["birth-field"]}>
        <Label for="year" required={required}>
          생년월일
        </Label>
        <div className={styles.birth}>
          <TextInput
            className={styles.year}
            id="year"
            name="year"
            type="text"
            placeholder="YYYY"
            onChange={handleChange}
            value={value.year}
            required={required}
          />
          <TextInput
            className={styles.month}
            name="month"
            type="text"
            placeholder="MM"
            onChange={handleChange}
            value={value.month}
            required={required}
          />
          <TextInput
            className={styles.day}
            name="day"
            type="text"
            placeholder="DD"
            onChange={handleChange}
            value={value.day}
            required={required}
          />
        </div>
      </Field>

      <p className={styles["rule-field"]}>
        {errorMessage.year || errorMessage.month || errorMessage.day}
      </p>
    </>
  );
};

export default BirthField;

BirthField.propTypes = {
  required: PropTypes.bool,
};

BirthField.defaultProps = {
  required: false,
};
