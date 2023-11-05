package com.applicationsec;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class ProcessBuilderClassTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            if (!className.equals("java/lang/ProcessBuilder")) {
                return null;
            }
            System.out.println("Class is being loaded by the JVM, it will transformed to include RASP probes : " + className);
            ClassReader reader = new ClassReader(classfileBuffer);
            ClassWriter writer = new ClassWriter(new ClassReader(classfileBuffer), ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            reader.accept(new ProcessBuilderClassVisitor(writer), ClassReader.EXPAND_FRAMES);
            return writer.toByteArray();
        }

}
