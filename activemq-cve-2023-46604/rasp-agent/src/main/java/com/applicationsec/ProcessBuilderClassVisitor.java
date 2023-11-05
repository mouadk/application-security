package com.applicationsec;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class ProcessBuilderClassVisitor extends ClassVisitor {

    public ProcessBuilderClassVisitor(ClassVisitor visitor){
        super(Opcodes.ASM7, visitor);
    }

    @Override
    public MethodVisitor visitMethod(int methodAccess, String methodName, String methodDesc, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = cv.visitMethod(methodAccess, methodName, methodDesc, signature, exceptions);
        return new ProcessBuilderClassAdapter(Opcodes.ASM7, methodVisitor, methodAccess, methodName, methodDesc);
    }

    public static class ProcessBuilderClassAdapter extends AdviceAdapter {
        private final String methodName;

        protected ProcessBuilderClassAdapter(int api, MethodVisitor methodVisitor, int methodAccess, String methodName, String methodDesc) {
            super(api, methodVisitor, methodAccess, methodName, methodDesc);
            this.methodName = methodName;
        }

        @Override
        protected void onMethodEnter() {
            if ("start".equals(methodName) && "()Ljava/lang/Process;".equals(methodDesc)) {
                mv.visitTypeInsn(NEW, "com/applicationsec/ProcessBuilderCheck");
                mv.visitInsn(DUP);
                mv.visitMethodInsn(INVOKESPECIAL, "com/applicationsec/ProcessBuilderCheck", "<init>", "()V", false);
                mv.visitVarInsn(ASTORE, 1);
                mv.visitVarInsn(ALOAD, 1);
                mv.visitVarInsn(ALOAD, 0);
                mv.visitFieldInsn(GETFIELD, "java/lang/ProcessBuilder", "command", "Ljava/util/List;");
                mv.visitMethodInsn(INVOKEVIRTUAL, "com/applicationsec/ProcessBuilderCheck", "check", "(Ljava/util/List;)V", false);
            }
        }
    }

}
