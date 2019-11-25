import React from "react";
import PropTypes from "prop-types";

import {makeStyles} from "@material-ui/core/styles";

import styles from "../../assets/js/material-dashboard-react/components/typographyStyle.jsx";

const useStyles = makeStyles(styles);

export default function Primary(props) {
    const classes = useStyles();
    const {children} = props;
    return (
        <div className={`${classes.defaultFontStyle} ${classes.primaryText}`}>
            {children}
        </div>
    );
}

Primary.propTypes = {
    children: PropTypes.node
};
