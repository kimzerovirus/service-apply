import React from "react";
import PropTypes from "prop-types";
import classNames from "classnames";

import styles from "./Box.module.css";

const Box = ({ title, size, children, className }) => {
  return (
    <div
      className={classNames(
        styles.box,
        { [styles.narrow]: size === "narrow" },
        className
      )}
    >
      {title && <h2 className={styles.title}>{title}</h2>}
      {children}
    </div>
  );
};

export default Box;

Box.propTypes = {
  title: PropTypes.string,
  size: PropTypes.oneOf(["default", "narrow"]),
  children: PropTypes.node.isRequired,
};

Box.defaultProps = {
  size: "default",
};
