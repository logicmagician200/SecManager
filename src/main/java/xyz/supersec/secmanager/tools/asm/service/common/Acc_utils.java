package xyz.supersec.secmanager.tools.asm.service.common;

import org.objectweb.asm.Opcodes;

public class Acc_utils {

    public static String parameter_acc(int accessFlags) {

        StringBuilder stringBuilder = new StringBuilder();
        if ((accessFlags & Opcodes.ACC_FINAL) != 0) {
            stringBuilder.append(AccessFlag.final_x);
        }
        if ((accessFlags & Opcodes.ACC_SYNTHETIC) != 0) {
            stringBuilder.append(AccessFlag.synthetic_x);
        }
        if ((accessFlags & Opcodes.ACC_MANDATED) != 0) {
            stringBuilder.append(AccessFlag.mandated_x);
        }

        String trim = stringBuilder.toString().trim();
        return trim;
    }

    public static String class_acc(int accessFlags) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((accessFlags & Opcodes.ACC_PUBLIC) != 0) {
            stringBuilder.append(AccessFlag.public_x);
        }
        if ((accessFlags & Opcodes.ACC_PRIVATE) != 0) {
            stringBuilder.append(AccessFlag.private_x);
        }
        if ((accessFlags & Opcodes.ACC_PROTECTED) != 0) {
            stringBuilder.append(AccessFlag.protected_x);
        }
        if ((accessFlags & Opcodes.ACC_FINAL) != 0) {
            stringBuilder.append(AccessFlag.final_x);
        }
        if ((accessFlags & Opcodes.ACC_SUPER) != 0) {
            stringBuilder.append(AccessFlag.super_x);
        }
        if ((accessFlags & Opcodes.ACC_INTERFACE) != 0) {
            stringBuilder.append(AccessFlag.interface_x);
        }
        if ((accessFlags & Opcodes.ACC_ABSTRACT) != 0) {
            stringBuilder.append(AccessFlag.abstract_x);
        }
        if ((accessFlags & Opcodes.ACC_SYNTHETIC) != 0) {
            stringBuilder.append(AccessFlag.synthetic_x);
        }
        if ((accessFlags & Opcodes.ACC_ANNOTATION) != 0) {
            stringBuilder.append(AccessFlag.annotation_x);
        }
        if ((accessFlags & Opcodes.ACC_ENUM) != 0) {
            stringBuilder.append(AccessFlag.enum_x);
        }
        if ((accessFlags & Opcodes.ACC_MODULE) != 0) {
            stringBuilder.append(AccessFlag.module_x);
        }
        if ((accessFlags & Opcodes.ACC_RECORD) != 0) {
            stringBuilder.append(AccessFlag.record_x);

        }
        if ((accessFlags & Opcodes.ACC_DEPRECATED) != 0) {
            stringBuilder.append(AccessFlag.deprecated_x);
        }

        String trim = stringBuilder.toString().trim();

        return trim;
    }


    public static String method_acc(int accessFlags) {
        StringBuilder stringBuilder = new StringBuilder();

        if ((accessFlags & Opcodes.ACC_PUBLIC) != 0) {
            stringBuilder.append(AccessFlag.public_x);
        }
        if ((accessFlags & Opcodes.ACC_PRIVATE) != 0) {
            stringBuilder.append(AccessFlag.private_x);
        }
        if ((accessFlags & Opcodes.ACC_PROTECTED) != 0) {
            stringBuilder.append(AccessFlag.protected_x);
        }
        if ((accessFlags & Opcodes.ACC_STATIC) != 0) {
            stringBuilder.append(AccessFlag.static_x);
        }
        if ((accessFlags & Opcodes.ACC_FINAL) != 0) {
            stringBuilder.append(AccessFlag.final_x);
        }
        if ((accessFlags & Opcodes.ACC_SYNCHRONIZED) != 0) {
            stringBuilder.append(AccessFlag.synchronized_x);
        }
        if ((accessFlags & Opcodes.ACC_BRIDGE) != 0) {
            stringBuilder.append(AccessFlag.bridge_x);
        }
        if ((accessFlags & Opcodes.ACC_VARARGS) != 0) {
            stringBuilder.append(AccessFlag.varargs_x);
        }
        if ((accessFlags & Opcodes.ACC_NATIVE) != 0) {
            stringBuilder.append(AccessFlag.native_x);
        }
        if ((accessFlags & Opcodes.ACC_ABSTRACT) != 0) {
            stringBuilder.append(AccessFlag.abstract_x);
        }
        if ((accessFlags & Opcodes.ACC_STRICT) != 0) {
            stringBuilder.append(AccessFlag.strict_x);
        }
        if ((accessFlags & Opcodes.ACC_SYNTHETIC) != 0) {
            stringBuilder.append(AccessFlag.synthetic_x);
        }
        if ((accessFlags & Opcodes.ACC_MANDATED) != 0) {
            stringBuilder.append(AccessFlag.mandated_x);
        }
        if ((accessFlags & Opcodes.ACC_DEPRECATED) != 0) {
            stringBuilder.append(AccessFlag.deprecated_x);
        }


        String trim = stringBuilder.toString().trim();
        return trim;
    }

    public static String field_acc(int accessFlags) {
        StringBuilder stringBuilder = new StringBuilder();

        if ((accessFlags & Opcodes.ACC_PUBLIC) != 0) {
            stringBuilder.append(AccessFlag.public_x);
        }
        if ((accessFlags & Opcodes.ACC_PRIVATE) != 0) {
            stringBuilder.append(AccessFlag.private_x);
        }
        if ((accessFlags & Opcodes.ACC_PROTECTED) != 0) {
            stringBuilder.append(AccessFlag.protected_x);
        }
        if ((accessFlags & Opcodes.ACC_STATIC) != 0) {
            stringBuilder.append(AccessFlag.static_x);
        }
        if ((accessFlags & Opcodes.ACC_FINAL) != 0) {
            stringBuilder.append(AccessFlag.final_x);
        }
        if ((accessFlags & Opcodes.ACC_VOLATILE) != 0) {
            stringBuilder.append(AccessFlag.volatile_x);
        }
        if ((accessFlags & Opcodes.ACC_TRANSIENT) != 0) {
            stringBuilder.append(AccessFlag.transient_x);
        }
        if ((accessFlags & Opcodes.ACC_SYNTHETIC) != 0) {
            stringBuilder.append(AccessFlag.synthetic_x);
        }
        if ((accessFlags & Opcodes.ACC_ENUM) != 0) {
            stringBuilder.append(AccessFlag.enum_x);
        }
        if ((accessFlags & Opcodes.ACC_MANDATED) != 0) {
            stringBuilder.append(AccessFlag.mandated_x);
        }
        if ((accessFlags & Opcodes.ACC_DEPRECATED) != 0) {
            stringBuilder.append(AccessFlag.deprecated_x);
        }

        String trim = stringBuilder.toString().trim();
        return trim;
    }

    private class AccessFlag {

        private final static String bridge_x = "bridge ";
        private final static String varargs_x = "varargs ";
        private final static String native_x = "native ";
        private final static String strict_x = "strict ";


        private final static String annotation_x = "annotation ";
        private final static String module_x = "module ";
        private final static String record_x = "record ";

        private final static String deprecated_x = "deprecated ";

        private final static String interface_x = "interface ";

        private final static String super_x = "super ";

        private final static String public_x = "public ";
        private final static String private_x = "private ";
        private final static String protected_x = "protected ";
        private final static String final_x = "final ";
        private final static String static_x = "static ";
        private final static String synchronized_x = "synchronized ";
        private final static String volatile_x = "volatile ";
        private final static String transient_x = "transient ";
        private final static String abstract_x = "abstract ";
        private final static String strictfp_x = "strictfp ";
        private final static String synthetic_x = "synthetic ";
        private final static String mandated_x = "mandated ";
        private final static String enum_x = "enum ";
    }


}
